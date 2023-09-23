from argparse import ArgumentParser

def main() -> None:
    parser = ArgumentParser(description="Generate Java code for an array containing all location offsets at a certain distance.")
    parser.add_argument("min", type=int, help="min distance to include offsets for")
    parser.add_argument("max", type=int, help="max distance to include offsets for")

    args = parser.parse_args()

    print("{")

    for y in range(-8, 9):
        row = []

        for x in range(-8, 9):
            if args.min <= x ** 2 + y ** 2 <= args.max:
                row.append((x, y))

        if len(row) > 0:
            print(", ".join(f"{{{x}, {y}}}" for x, y in row) + ",")

    print("}")

if __name__ == "__main__":
    main()
