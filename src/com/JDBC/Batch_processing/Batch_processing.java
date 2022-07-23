package com.JDBC.Batch_processing;

import com.JDBC.JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Batch_processing {
        ////传统方法，添加 5000 条数据到 admin2
        @Test
        public void noBatch() throws Exception {
            Connection connection = JDBCUtils.getconnection();
            String sql = "insert into admin2 values(null,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("执行");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1,"jack"+i);
                preparedStatement.setString(2,"666666");
                preparedStatement.executeUpdate();
            }

            long end = System.currentTimeMillis();
            System.out.println("传统方式总共耗时：" + (end - start));
            JDBCUtils.close(null,preparedStatement,connection);
        }
    @Test
    public void Batch() throws Exception {
        Connection connection = JDBCUtils.getconnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack"+i);
            preparedStatement.setString(2,"666666");




            preparedStatement.addBatch();
            /*
                源码分析：
                //将 sql 语句加入到批处理包中 -> 看源码
                //1. 第一次就创建 ArrayList - elementData => Object[]
                //2. elementData => Object[] 就会存放我们预处理的 sql 语句
                //3. 当 elementData 满后,就按照 1.5 扩容
                //4. 当添加到指定的值后，就 executeBatch
                //5. 批量处理会减少我们发送 sql 语句的网络开销，而且减少编译次数，因此效率提高
                public void addBatch() throws SQLException {
                    synchronized(this.checkClosed().getConnectionMutex()) {
                        if (this.batchedArgs == null) {
                            this.batchedArgs = new ArrayList();
                        }
                        for(int i = 0; i < this.parameterValues.length; ++i) {
                                this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                        }

                        this.batchedArgs.add(new PreparedStatement.BatchParams
                                                    (this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                        }
                 }
             */
            if ((i + 1) %1000 == 0){  //每满1000条就批量执行
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("批处理方式总共耗时：" + (end - start));
        JDBCUtils.close(null,preparedStatement,connection);
    }

}
