package com.I_OStream.Reader_;

public class Test {
    public static void main(String[] args) {
        BUfferReader_ bUfferReader_ = new BUfferReader_(new FileReader_());
        bUfferReader_.ReaderFile(2);

        //希望通过BufferReader_ 多次读取字符串
        BUfferReader_ bUfferReader_1 = new BUfferReader_(new StringReader_());
        bUfferReader_1.ReaderString(3);
    }
}
