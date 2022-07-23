package com.I_OStream.Reader_;

public class BUfferReader_ extends Reader_ {
    private Reader_ reader_;

    public BUfferReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
    //方便灵活，多次读取文件
    public void ReaderFile(int num){
        for (int i = 0; i < num; i++) {
            reader_.ReaderFile();
        }
    }

    //扩展ReaderString.批量处理字符数据
    public void ReaderString(int num){
        for (int i = 0; i < num; i++) {
            reader_.ReaderString();
        }
    }
}
