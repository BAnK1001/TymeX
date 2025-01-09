def find_missing_number(arr):
    n = len(arr)
    expected_sum = (n + 1) * (n + 2) // 2
    actual_sum = sum(arr)
    return expected_sum - actual_sum

# Example usage:
arr = [3, 7, 1, 2, 6, 4]
missing_number = find_missing_number(arr)
print(f"The missing number is: {missing_number}")
