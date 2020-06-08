import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:数组的练习
 * User: GAOBO
 * Date: 2020-03-14
 * Time: 11:32
 */
public class TestDemo2 {

    /**
     * 数组的拷贝：
     * 1、for
     * 2、System.arraycopy
     * (Object src, int srcPos, Object dest, int destPos, int length)
     * Object-->是所有类的父类
     * src:源数组
     * srcPos:源数组的开始拷贝的下标
     * dest：目的数组
     * destPos：拷贝到目的数组的这个下标
     * length：拷贝多大
     * 3、Arrays.copyOf(int[] original, int newLength) ；
     *  底层调用的方法是：System.arraycopy
     * 4、了解：clone()--->Object
     * clone()
     * 创建并返回此对象的副本。
     *
     * 总结：
     * 以上4中拷贝方式 全部都是浅拷贝！
     * 如果数组当中的元素是简单类型，那么他是深拷贝
     * 如果数组当中存放的引用类型，那么他是浅拷贝
     * @param array
     * @return
     */
    public static int[] copyArray(int[] array) {
        int[] array2 = new int[array.length];
        for(int i=0; i < array.length;i++) {
            array2[i] = array[i];
        }
        return array2;
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println("拷贝前array："+ Arrays.toString(array));
        int[] ret = Arrays.copyOf(array,array.length);
        ret[0] = 999;
        System.out.println("拷贝后ret修改:"+Arrays.toString(ret));
        System.out.println("拷贝后array："+ Arrays.toString(array));


       /* int[] ret = array.clone();
        System.out.println("ret:"+Arrays.toString(ret));
*/

        /*int[] ret = Arrays.copyOf(array,array.length);
        System.out.println("ret:"+Arrays.toString(ret));*/


       /* int[] dest = new int[array.length];
        //拷贝更快一点：native方法
        System.arraycopy(array,0,dest,0,array.length);
        System.out.println("dest"+Arrays.toString(dest));*/
       /* int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));*/
    }

    /**
     * 自己写一个toString();
     * 写代码，写题的时候，
     * 有可能我们并不能完全考虑到代码的全部
     *
     */
    public static String myToString(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if(i != array.length-1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        //[1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(array));
        System.out.println(myToString(array));
    }
}
