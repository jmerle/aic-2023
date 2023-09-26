def offset_to_string(variable: str, offset: int) -> str:
    if offset == 0:
        return variable
    elif offset > 0:
        return f"({variable} + {offset})"
    else:
        return f"({variable} - {abs(offset)})"

def generate_method(name: str, offsets: list[tuple[int, int]]) -> None:
    print(f"private void {name}() {{")
    print("Location myLocation = uc.getLocation();")
    print("int myX = myLocation.x;")
    print("int myY = myLocation.y;")
    print("int height = GameConstants.MAX_MAP_SIZE;")
    print("int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;")
    print("int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;")
    print("int index;")
    print("\nif (xOffsetSubtract && yOffsetSubtract) {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"index = (yOffset - {offset_to_string('myY', dy)}) * height + (xOffset - {offset_to_string('myX', dx)});")
        print("if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);")

    print("} else if (xOffsetSubtract) {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"index = ({offset_to_string('myY', dy)} - yOffset) * height + (xOffset - {offset_to_string('myX', dx)});")
        print("if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);")

    print("} else if (yOffsetSubtract) {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"index = (yOffset - {offset_to_string('myY', dy)}) * height + ({offset_to_string('myX', dx)} - xOffset);")
        print("if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);")

    print("} else {")

    for i, (dx, dy) in enumerate(offsets):
        if i > 0:
            print()

        print(f"index = ({offset_to_string('myY', dy)} - yOffset) * height + ({offset_to_string('myX', dx)} - xOffset);")
        print("if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);")

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
