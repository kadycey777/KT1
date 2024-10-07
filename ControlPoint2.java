//1) НАЙДИТЕ ИНДЕКС ПЕРВОГО ВХОЖДЕНИЯ В СТРОКУ.
//Учитывая две строки needle и haystack, верните индекс первого вхождения needlein haystack или, -1если needleон не является частью haystack.
//Пример 1:
//Ввод: haystack = «sadbutsad», Needle = «sad»
//Выход: 0
//Объяснение: «sad» встречается в индексах 0 и 6.
//Первое вхождение имеет индекс 0, поэтому мы возвращаем 0.
//Пример 2:
//Ввод: haystack = "leetcode", Needle = "leeto"
//Вывод: -1
//Объяснение: "leeto" не встречается в "leetcode", поэтому мы возвращаем -1.
//
//        2) ТРЕУГОЛЬНИК ПАСКАЛЯ
//
//Учитывая целое число numRows, верните первые numRows треугольника Паскаля.
//В треугольнике Паскаля каждое число представляет собой сумму двух чисел, находящихся непосредственно над ним, как показано:
//Пример 1:
//Ввод: numRows = 5
//Вывод: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Пример 2:
//Ввод: numRows = 1
//Вывод: [[1]]
//
//
//        3) ЭЛЕМЕНТ БОЛЬШИНСТВА.
//Учитывая массив nums размера n, верните элемент большинства.
//
//Элемент большинства — это элемент, который появляется более ⌊n / 2⌋ одного раза. Вы можете предположить, что элемент большинства всегда существует в массиве.
//        Пример 1:
//Ввод: nums = [3,2,3]
//Вывод: 3
//Пример 2:
//Ввод: nums = [2,2,1,1,1,2,2]
//Вывод: 2
//
//        4)СТЕПЕНЬ ДВОЙКИ
//Учитывая целое число n, верните значение true, если оно является степенью двойки. В противном случае верните false .
//Целое число n является степенью двойки, если существует целое число x такое, что .n == 2x
//Пример 1:
//Входные данные: n = 1
//Выходные данные: true
//Объяснение: 2 0 = 1
//Пример 2:
//
//Входные данные: n = 16
//Выходные данные: true
//Объяснение: 2 4 = 16
//Пример 3:
//Входные данные: n = 3
//Выходные данные: ложь
//    5)ПРОПАВШИЕ ЧИСЛА
//Учитывая массив nums целых n чисел где nums[i] находится в диапазоне [1, n], верните массив всех целых чисел в диапазоне [1, n] , которые не входят в nums диапазон .
//Пример 1:
//Ввод: числа = [4,3,2,7,8,2,3,1]
//Вывод: [5,6]
//Пример 2:
//Ввод: nums = [1,1]
//Вывод: [2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ControlPoint2 {

    public static int substringInd(){
        return  0;
    }

//    public static  String pascal(int numRows){
//        if (numRows == 1) {
//            int[][] preA = {{1}};
//            return Arrays.deepToString(preA);
//        }
//        if (numRows == 2){
//            int[][] preA ={{1}, {1, 1}};
//            return Arrays.deepToString(preA);
//        }
//
//        //идея - создаем [numRows][1-> numRows], 0 и ([][].length-1) индексы = 1, остальные = сумме соседних индексов из массивы выше (рекусрсия???)
//        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
//        //answer.add(new ArrayList[]{1});
//        //answer.add(new ArrayList[]{1, 1});
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numRows; j++) {
//                if((j == 0) || (j == answer.size() -1)){
//                    answer.get(i).add(1);
//                }
//            }
//        }
//        int[][] ans = {{1,5,6},{2,6}};
//        return  Arrays.deepToString(ans);
//
//    }


    public static int analysis(int[] nums){
        // коллекция - ключ-число, вернуть наибольшее
        Map<Integer,Integer> dictionary = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (dictionary.containsKey(nums[i])){
                Integer count = dictionary.get(nums[i]);
                dictionary.replace(nums[i], count, count+1);
            }
            else
                dictionary.put(nums[i],1);
        }
        int max = 0;
        int maxKey = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < dictionary.get(nums[i])) {
                max = dictionary.get(nums[i]);
                maxKey = nums[i];
            }
        }
        return  maxKey;
        }

    public static boolean checker(int num){
        // мат.log[checkableBase](num)
        for (int i = 0; i < num; i++) {
            if (num == Math.pow(2,i))
                return true;
        }
        return false;
    }

    public static ArrayList<Integer> lostNums(int[] nums) {
        //идея - аррейсим, сортим, бинари серчим, если не находим - кидаем в выходной массив, получаем n*log
        Arrays.sort(nums);
        ArrayList<Integer> lostNums = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if( Arrays.binarySearch(nums,i) < 0){
                lostNums.add(i);
            }
        }
        return lostNums;
    }

    public static void main(String[] args){
        // 1) НАЙДИТЕ ИНДЕКС ПЕРВОГО ВХОЖДЕНИЯ В СТРОКУ.
        // 2) ТРЕУГОЛЬНИК ПАСКАЛЯ
        //System.out.println(pascal(1));

        // 3) ЭЛЕМЕНТ БОЛЬШИНСТВА.
        int[] test = {3,2,3};
        System.out.println( analysis( test ) );
        // 4)СТЕПЕНЬ ДВОЙКИ
        int one = 128;
        int two = 129;
        System.out.println(checker(one));
        System.out.println(checker(two));
        // 5)ПРОПАВШИЕ ЧИСЛА
        int[] lostTest1 ={4,3,2,7,8,2,3,1};
        int[] lostTest2 ={1,1};
        System.out.println(lostNums( lostTest1 ));
        System.out.println(lostNums( lostTest2 ));


    }
}


