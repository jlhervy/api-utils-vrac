package com.jl.hbasetraining;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;

import java.io.IOException;

public class CreateTable {
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionFactory.createConnection();
        try {
            Admin admin = connection.getAdmin();

            TableDescriptor tableDescriptor = TableDescriptorBuilder
                          .newBuilder(TableName.valueOf("census"))
                          .setColumnFamily(ColumnFamilyDescriptorBuilder.newBuilder("personal".getBytes()).build())
                          .setColumnFamily(ColumnFamilyDescriptorBuilder.newBuilder("professional".getBytes()).build())
                          .build();

            
            if (!admin.tableExists(tableDescriptor.getTableName())) {
                System.out.println("Creating the census table. ");
                admin.createTable(tableDescriptor);

                System.out.println("Done.");
            } else {
                System.out.println("Table already exists.");
            }
        } finally {
            connection.close();
        }
    }
}
