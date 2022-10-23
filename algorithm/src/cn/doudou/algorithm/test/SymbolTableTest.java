package cn.doudou.algorithm.test;

import cn.doudou.algorithm.symbol.SymbolTable;

/**
 * Create By 王嘉浩
 * Time 2022-10-23 15:19
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<String, String> st = new SymbolTable<>();

        //测试插入
        st.put("1", "A");
        st.put("2", "B");
        st.put("3", "C");
        st.put("4", "D");
        System.out.println(st.size());
        //测试替换
        st.put("2", "A");
        System.out.println(st.get("2"));
        //测试get()
        st.get("2");
        //测试删除
        st.delete("2");
        System.out.println(st.size());
    }
}
