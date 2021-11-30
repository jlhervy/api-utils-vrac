package com.jl.hbasetraining;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class DeleteTable {
    public static void main(String[] args) throws IOException {

        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);

        Table table = null;

        try {

            Admin admin = connection.getAdmin();

            TableName tableName = TableName.valueOf("census");

            if (admin.tableExists(tableName)) {

                System.out.print("Table exists, Deleting... ");

                admin.disableTable(tableName);
                admin.deleteTable(tableName);

                System.out.println("Done.");
            } else {
                System.out.println("Table does not exist.");
            
            }

        } finally {
            connection.close();
        }
    }
}
