package itc.org.com


import org.apache.log4j.{Level,Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode,SparkSession}
import org.apache.spark.sql.types.{IntegerType,StringType,StructField}

object movie1 extends App{
  //System.setProperty("hadoop.home.dir", "C:\\hadoop")
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "kaf")
  //sparkConf.set("spark.master", "local[1]")

  val spark=SparkSession.builder().config(sparkConf).getOrCreate()
  import spark.implicits
  val df = spark.read.option("header", true).option("inferschema", true).csv("/user/ec2-user/junbatch/sonika/topmovie.csv")
      df.where(df("vote_average==8")).show()
    df.show(5)



}
