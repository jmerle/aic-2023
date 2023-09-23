import subprocess
import sys
from datetime import datetime
from pathlib import Path
from rich.console import Console
from threading import Lock

replay_name_lock = Lock()

seed = None
replay_name = None

def get_timestamp() -> str:
    return datetime.now().strftime("%Y-%m-%d_%H-%M-%S")

def get_replay_name(player1: str, player2: str, map: str, timestamp: str = get_timestamp()) -> str:
    global seed
    global replay_name

    with replay_name_lock:
        if seed is None or replay_name is None:
            lines = (Path(__file__).parent.parent / "gradle.properties").read_text(encoding="utf-8").splitlines()
            seed = next(line for line in lines if line.startswith("seed=")).split("=", 1)[1]
            replay_name = next(line for line in lines if line.startswith("replayName=")).split("=", 1)[1]

    return replay_name \
        .replace("%PLAYER1%", player1) \
        .replace("%PLAYER2%", player2) \
        .replace("%MAP%", map) \
        .replace("%SEED%", seed) \
        .replace("%TIMESTAMP%", timestamp)

def get_viewer_url(replay_name: str) -> str:
    return f"https://www.coliseum.ai/app/viewer?lang=en&tournament=aic2023&replay=games%2F{replay_name}.txt"

def instrument(console: Console, player1: str, player2: str) -> None:
    instrument_task = "instrument" if player1 != player2 else "instrument1"
    instrument_process = subprocess.run([
        str(Path(__file__).parent.parent / "gradlew"), instrument_task,
        f"-Pplayer1={player1}",
        f"-Pplayer2={player2}"
    ])

    if instrument_process.returncode != 0:
        console.print(f"Gradle exited with status code {instrument_process.returncode} after instrumenting")
        sys.exit(instrument_process.returncode)
