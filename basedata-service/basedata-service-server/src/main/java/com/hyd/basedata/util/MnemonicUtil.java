package com.hyd.basedata.util;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:10
 */
public class MnemonicUtil {
    private MnemonicUtil(){}
    public static String buildMnemonic(String s) {
        StringBuilder mnemonicBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            String[] array = PinyinHelper.toHanyuPinyinStringArray(c);
            if (array != null) {
                mnemonicBuilder.append(array[0].charAt(0));
            } else {
                mnemonicBuilder.append(c);
            }
        }
        return mnemonicBuilder.toString().toUpperCase();
    }
}
