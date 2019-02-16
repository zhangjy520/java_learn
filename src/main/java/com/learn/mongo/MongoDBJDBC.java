package com.learn.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.regex.Pattern;

public class MongoDBJDBC{
   public static void main( String args[] ){
      try{
       // 连接到 mongodb 服务
         MongoClient mongoClient = new MongoClient( "47.94.98.20" , 27017 );
       
         // 连接到数据库
         MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

          MongoCollection<Document> collection = mongoDatabase.getCollection("test");

          Pattern queryPattern = Pattern.compile("MongoDB92", Pattern.CASE_INSENSITIVE);

          BasicDBObject queryObject = new BasicDBObject("assetName",queryPattern);

          FindIterable<Document> findIterable = collection.find(queryObject);
          MongoCursor<Document> cursor = findIterable.iterator();

          while(cursor.hasNext()){

              System.out.println(cursor.next());

          }
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
}