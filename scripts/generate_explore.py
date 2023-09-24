def generate_method(name: str, offsets: list[tuple[int, int]]) -> None:
    print(f"private void {name}() {{")
    print("Location myLocation = uc.getLocation();")
    print("Location location;")
    print("\nif (xOffsetSubtract && yOffsetSubtract) {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"location = myLocation.add({dx}, {dy});")
        print("if (!uc.isOutOfMap(location)) {")
        print("rows[yOffset - location.y] |= 1L << (xOffset - location.x);")
        print("}")

    print("} else if (xOffsetSubtract) {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"\nlocation = myLocation.add({dx}, {dy});")
        print("if (!uc.isOutOfMap(location)) {")
        print("rows[location.y - yOffset] |= 1L << (xOffset - location.x);")
        print("}")

    print("} else if (yOffsetSubtract) {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"location = myLocation.add({dx}, {dy});")
        print("if (!uc.isOutOfMap(location)) {")
        print("rows[yOffset - location.y] |= 1L << (location.x - xOffset);")
        print("}")

    print("} else {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"location = myLocation.add({dx}, {dy});")
        print("if (!uc.isOutOfMap(location)) {")
        print("rows[location.y - yOffset] |= 1L << (location.x - xOffset);")
        print("}")

    print("}")
    print("}")

def main() -> None:
    for min, max in [[13, 20], [20, 32], [45, 64]]:
        full_offsets = []
        partial_offsets = []

        for y in range(-8, 9):
            for x in range(-8, 9):
                distance = x ** 2 + y ** 2
                if distance <= max:
                    full_offsets.append((x, y))
                    if distance >= min:
                        partial_offsets.append((x, y))

        generate_method(f"markExploredFull{max}", full_offsets)
        print()
        generate_method(f"markExploredPartial{max}", partial_offsets)

if __name__ == "__main__":
    main()
