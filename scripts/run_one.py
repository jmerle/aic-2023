import subprocess
import sys
import webbrowser
from argparse import ArgumentParser
from common import get_replay_name, get_viewer_url, instrument
from pathlib import Path
from rich.console import Console

def main() -> None:
    parser = ArgumentParser(description="Run a single match between two players.")
    parser.add_argument("player1", type=str, help="name of the first player")
    parser.add_argument("player2", type=str, help="name of the second player")
    parser.add_argument("map", type=str, help="name of the map")
    parser.add_argument("-m", "--mode", choices=["normal", "debug", "silent"], default="normal", help="the mode to run in (default: normal)")
    parser.add_argument("-o", "--open", action="store_true", help="open the replay in the viewer when done")

    args = parser.parse_args()

    replay_name = get_replay_name(args.player1, args.player2, args.map)
    task = {
        "normal": "run",
        "debug": "runDebug",
        "silent": "runSilent"
    }[args.mode]

    console = Console(highlight=False)
    instrument(console, args.player1, args.player2)

    process = subprocess.run([
        str(Path(__file__).parent.parent / "gradlew"), task,
        "-x", "compileJava",
        "-x", "classes",
        "-x", "instrument",
        f"-Pplayer1={args.player1}",
        f"-Pplayer2={args.player2}",
        f"-Pmap={args.map}",
        f"-PreplayName={replay_name}"
    ])

    if process.returncode != 0:
        console.print(f"Gradle exited with status code {process.returncode}")
        sys.exit(process.returncode)

    viewer_url = get_viewer_url(replay_name)

    console.print(f"\nReplay: {viewer_url}")
    if args.open:
        webbrowser.open(viewer_url)

if __name__ == "__main__":
    main()
