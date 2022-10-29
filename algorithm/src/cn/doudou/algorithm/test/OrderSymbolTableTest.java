package cn.doudou.algorithm.test;

import cn.doudou.algorithm.symbol.OrderSymbolTable;
import cn.doudou.algorithm.symbol.SymbolTable;

/**
 * Create By 王嘉浩
 * Time 2022-10-23 16:00
 */
public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> st = new OrderSymbolTable<>();
        st.put(1, "A");
        st.put(2, "B");
        st.put(4, "D");
        st.put(3, "C");
    }
}
