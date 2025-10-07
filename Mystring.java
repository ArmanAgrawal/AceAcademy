import java.util.Scanner;

public class Mystring { 

    private StringBuilder sb;

    public Mystring(String s) {
        sb = new StringBuilder(s);
    }

    public void append(String st) {
        sb.append(' ').append(st);
        System.out.println("After append: " + sb.toString());
    }

    public int cntword() {
        int cnt = 0;
        boolean isword = false;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' && !isword) {
                isword = true;
                cnt++;
            } else if (sb.charAt(i) == ' ') {
                isword = false;
            }
        }
        return cnt;
    }

    public void replace(String target, String rep) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int tlen = target.length();

        while (i < sb.length()) {
            int j = 0;
            while (j < tlen && i + j < sb.length() && sb.charAt(i + j) == target.charAt(j)) {
                j++;
            }
            if (j == tlen) {
                result.append(rep);
                i += tlen;
            } else {
                result.append(sb.charAt(i));
                i++;
            }
        }
        sb = result;
        System.out.println(sb.toString());

    }

    public boolean ispalindrom() {
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public void splice(int s, int length) {
        int end = Math.min(s + length, sb.length());
        sb.delete(s, end);
        System.out.println("After splice: " + sb.toString());
    }

    public String[] split(String a) {
        char del = a.charAt(0);
        int cnt = 1;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == del)
                cnt++;
        }
        String[] parts = new String[cnt];

        StringBuilder word = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == del) {
                parts[idx++] = word.toString();
                word.setLength(0);
            } else {
                word.append(c);
            }
        }
        parts[idx] = word.toString();
        return parts;
    }

    public void maxrepeat() {
        int[] freq = new int[256];
        int maxi = 0;
        char maxc = ' ';
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            freq[c]++;
            if (freq[c] > maxi) {
                maxi = freq[c];
                maxc = c;
            }
        }
        System.out.println(maxc + " -> " + maxi);
    }

    public void shift(int n) {
        if (sb.length() == 0)
            return;
        n = n % sb.length();
        if (n == 0)
            return;
        String shif = sb.substring(0, n);
        sb.delete(0, n);
        sb.append(shif);

        System.out.println(sb.toString());
    }

    public void reverse() {
        int l = 0;
        int r = sb.length() - 1;
        while (l < r) {
            char t = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, t);
            l++;
            r--;
        }
        System.out.println(sb.toString());
    }

 public void sort() {
    char[] arr = new char[sb.length()];
    for (int i = 0; i < sb.length(); i++)
        arr[i] = sb.charAt(i);

    mergeSort(arr, 0, arr.length - 1);

    sb.setLength(0);
    sb.append(arr);
    System.out.println(sb.toString());
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
    StringBuilder temp = new StringBuilder();
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j])
            temp.append(arr[i++]);
        else
            temp.append(arr[j++]);
    }
    while (i <= mid) temp.append(arr[i++]);
    while (j <= right) temp.append(arr[j++]);
    for (int k = 0; k < temp.length(); k++) {
        arr[left + k] = temp.charAt(k);
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial string: ");
        String s = sc.nextLine();
        Mystring a = new Mystring(s);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. Max Repeating Character");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Enter string to append: ");
                    a.append(sc.nextLine());
                    break;

                case 2:
                    System.out.println("Word count: " + a.cntword());
                    break;

                case 3:
                    System.out.print("Enter target substring: ");
                    String t = sc.nextLine();
                    System.out.print("Enter replacement: ");
                    String r = sc.nextLine();
                    a.replace(t, r);
                    break;

                case 4:
                    System.out.println(a.ispalindrom() ? "Palindrome" : "Not Palindrome");
                    break;

                case 5:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter length: ");
                    int len = sc.nextInt();
                    sc.nextLine();
                    a.splice(start, len);
                    break;

                case 6:
                    System.out.print("Enter string from which to Seperate: ");
                    String del = sc.nextLine();
                    String[] parts = a.split(del);
                    System.out.println("Split parts:");
                    for (String part : parts)
                        System.out.println(part);
                    break;

                case 7:
                    a.maxrepeat();
                    break;

                case 8:
                    a.sort();

                    break;

                case 9:
                    System.out.print("Enter number of characters : ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    a.shift(n);
                    break;

                case 10:
                    a.reverse();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
