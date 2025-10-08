/**
 * @filename - MyString.java
 * @description - This will perform all string operations
 * @author - Arman Agrawal
 */

public class MyString {

    private String value = "arman";

    public MyString(String text) {
        this.value = new String(text);
    }

    public String append(String text) {
        this.value = this.value + " " + text;
        return this.value;
    }

    public int countWord() {
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (this.value.charAt(i) == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    public String replace(String target, String replacement) {
        String result = "";
        int index = 0;
        int valueLength = this.value.length();
        int targetLength = target.length();

        while (index < valueLength) {
            boolean match = false;

            if (index + targetLength <= valueLength) {
                match = true;
                for (int j = 0; j < targetLength; j++) {
                    if (this.value.charAt(index + j) != target.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            }

            if (match) {
                result += replacement;
                index += targetLength;
            } else {
                result += this.value.charAt(index);
                index++;
            }
        }

        this.value = result;
        return this.value;
    }

    public boolean isPalindrome() {
        int left = 0, right = this.value.length() - 1;
        while (left < right) {
            if (this.value.charAt(left) != this.value.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public String splice(int start, int length) {
        int currentLength = this.value.length();
        int end = start + length;
        if (end > currentLength)
            end = currentLength;

        String result = "";

        for (int i = 0; i < start; i++) {
            result += this.value.charAt(i);
        }

        for (int i = end; i < currentLength; i++) {
            result += this.value.charAt(i);
        }

        this.value = result;
        return this.value;
    }

    public String[] split(String delimiterString) {
        char delimiter = delimiterString.charAt(0);
        int count = 1;
        for (int i = 0; i < this.value.length(); i++)
            if (this.value.charAt(i) == delimiter)
                count++;

        String[] parts = new String[count];
        String word = "";
        int index = 0;
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) == delimiter) {
                parts[index++] = word;
                word = "";
            } else {
                word += this.value.charAt(i);
            }
        }
        parts[index] = word;
        return parts;
    }

    public String getMaximumRepeatChar() {
        int[] frequency = new int[256];
        int maxFrequency = 0;
        char maxChar = ' ';
        for (int i = 0; i < this.value.length(); i++) {
            char c = this.value.charAt(i);
            frequency[c]++;
            if (frequency[c] > maxFrequency) {
                maxFrequency = frequency[c];
                maxChar = c;
            }
        }
        return maxChar + " -> " + maxFrequency;
    }

    public String reverse() {
        String reverseString = "";
        for (int i = this.value.length() - 1; i >= 0; i--)
            reverseString += this.value.charAt(i);
        this.value = reverseString;
        return this.value;
    }

    public String shift(int n) {
        int len = this.value.length();
        if (len == 0)
            return " ";
        n = n % len;
        if (n == 0)
            return " ";
        String result = "";
        for (int i = n; i < len; i++) {
            result += this.value.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            result += this.value.charAt(i);
        }
        this.value = result;
        return this.value;
    }

    public String sort() {
        char[] arr = this.value.toCharArray();
        mergeSort(arr, 0, arr.length - 1);
        this.value = new String(arr);
        return this.value;
    }

    void mergeSort(char[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    void merge(char[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        char[] temp = new char[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[index++] = arr[i++];
            else
                temp[index++] = arr[j++];
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= right)
            temp[index++] = arr[j++];
        for (int k = 0; k < temp.length; k++)
            arr[left + k] = temp[k];
    }

}