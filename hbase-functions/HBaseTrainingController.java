package com.jl.hbasetraining;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

@RestController
public class HBaseTrainingController {

    private static byte[] PERSONAL_CF = Bytes.toBytes("personal");
    private static byte[] PROFESSIONAL_CF = Bytes.toBytes("professional");

    private static byte[] NAME_COLUMN = Bytes.toBytes("name");
    private static byte[] FIELD_COLUMN = Bytes.toBytes("field");

    private Table table;

    HBaseTrainingController() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("census"));
        this.table = table;
    }

    @GetMapping("/census/{id}")
    Information one(@PathVariable Long id) throws IOException {
        // Connection connection = ConnectionFactory.createConnection();

        // Table table = null;
        byte[] nameValue;
        byte[] fieldValue;
        try {
            // table = connection.getTable(TableName.valueOf("census"));

            Get get = new Get(Bytes.toBytes(id.toString()));

            get.addColumn(PERSONAL_CF, NAME_COLUMN);
            get.addColumn(PROFESSIONAL_CF, FIELD_COLUMN);

            Result result = table.get(get);

            nameValue = result.getValue(PERSONAL_CF, NAME_COLUMN);
            System.out.println("Name : " + Bytes.toString(nameValue));

            fieldValue = result.getValue(PROFESSIONAL_CF, FIELD_COLUMN);
            System.out.println("Field " + Bytes.toString(fieldValue));

        } finally {
            // connection.close();
            // if (table != null) {
            //     table.close();
            // }
        }
        Information inf = new Information(Bytes.toString(nameValue), Bytes.toString(fieldValue));
        return inf;

    }
}
