import shutil
import sys
from argparse import ArgumentParser
from pathlib import Path

def format_path(path: Path) -> str:
    cwd = Path.cwd()
    return str(path.relative_to(cwd)) if path.is_relative_to(cwd) else str(path)

def main() -> None:
    parser = ArgumentParser(description="Duplicate a player and update references to the source player's name in the target player.")
    parser.add_argument("source_player", type=str, help="name of the player to copy")
    parser.add_argument("target_player", type=str, help="name of the new player")

    args = parser.parse_args()

    source_directory = Path(__file__).parent.parent / "src" / args.source_player
    if not source_directory.is_dir():
        print(f"{format_path(source_directory)} does not exist")
        sys.exit(1)

    target_directory = Path(__file__).parent.parent / "src" / args.target_player
    if target_directory.is_dir():
        print(f"{format_path(target_directory)} already exists")
        sys.exit(1)

    print(f"Duplicating {format_path(source_directory)} to {format_path(target_directory)}")

    shutil.copytree(source_directory, target_directory)

    for file in target_directory.rglob("*.java"):
        content = file.read_text(encoding="utf-8")
        content = content.replace(f"package {args.source_player}", f"package {args.target_player}")
        content = content.replace(f"import {args.source_player}", f"import {args.target_player}")
        file.write_text(content, encoding="utf-8")

if __name__ == "__main__":
    main()
