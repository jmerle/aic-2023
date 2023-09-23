from argparse import ArgumentParser

def main() -> None:
    parser = ArgumentParser(description="Generate Java code for an array containing all location offsets within a certain range.")
    parser.add_argument("range", type=int, help="range to generate array for")

    args = parser.parse_args()

    print("{")

    for y in range(-8, 9):
        row = []

        for x in range(-8, 9):
            if x ** 2 + y ** 2 <= args.range:
                row.append((x, y))

        if len(row) > 0:
            print(", ".join(f"{{{x}, {y}}}" for x, y in row) + ",")

    print("}")

if __name__ == "__main__":
    main()
