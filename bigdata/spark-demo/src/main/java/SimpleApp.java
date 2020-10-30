import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * @author: gan
 * @date: 2020/10/30
 */
public class SimpleApp {
    public static void main(String[] args) {
        String file = "/tmp/spark.txt";
        SparkSession sparkSession = SparkSession.builder().appName("SimpleApp").getOrCreate();
        Dataset<String> dataset = sparkSession.read().textFile(file);

        long numAs = dataset.filter((FilterFunction<String>) s -> s.contains("a")).count();
        long numBs = dataset.filter((FilterFunction<String>) s -> s.contains("b")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
        sparkSession.stop();

    }
}
