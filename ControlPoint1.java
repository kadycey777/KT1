
public class ControlPoint1 {

    public static int target(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }

    public static int checkSum(int num){
        return (num / 100) + (num % 10) + (num / 10) % 10;
    }

    public static int minLengthOfStrs(String[] strs){
        int min = 1000000;
        for (int i = 0; i < strs.length - 1; i++) {
            min = Math.min(min, Math.min(strs[i].length(),strs[i+1].length()));
        }
        return min;
    }
    public static String checkPref(String[] strs){
        int maxSubsLength = minLengthOfStrs(strs);
        String check = "";
        String result = "";
        boolean bFlag = true;
        for (int substrInd = 0; substrInd <= maxSubsLength; substrInd++) {
            for (int word = 0; word < strs.length - 1; word++) {
                if(strs[word].substring( 0, substrInd).equals( strs[word+1].substring( 0, substrInd)))
                    check = strs[word].substring( 0, substrInd);
                else {
                    if (word != 0)
                        bFlag = false;
                    break;
                }
            }
            if (bFlag)
                result = check;
        }
        return result;
    }

    public static void main(String[] args){
//1)	Учитывая отсортированный массив различных целых чисел и целевое значение, верните индекс, если цель найдена.
// Если нет, верните индекс там, где он был бы, если бы он был вставлен по порядку.
        int[] nums = { 1, 3, 5, 6};
        System.out.println(target( nums, 5));
        System.out.println(target( nums, 2));
        System.out.println(target( nums, 7));

        System.out.println("--------------------------");
// 2)	Написать код, который выводит числа от 0 до 1000, которые делятся на 3, но не делятся на 5, и сумма цифр в которых меньше десяти.
        for (int i = 0; i < 1000; i++) {
            if ((i % 3 == 0) && (i % 5 != 0) && (checkSum(i) < 10))
                System.out.println(i);
        }
        System.out.println("--------------------------");
// 3)	Напишите метод для поиска самой длинной строки общего префикса среди массива строк. Если общего префикса нет, верните пустую строку "".
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(checkPref(strs));
        System.out.println(checkPref(strs2));
        System.out.println(checkPref(new String[]{"saass","saasds","saas","saasdsds"}));

    }
}
