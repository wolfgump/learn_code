import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;

import java.net.InetAddress;
import java.io.*;

/**
 * @author: gan
 * @date: 2020/10/23
 */
public class GeoIPConvert {
    public static void main(String[] args) throws IOException, GeoIp2Exception {
//        asn("183.200.7.182");
        city("183.200.7.182");
    }

    private static void asn(String ip) throws IOException, GeoIp2Exception {
        // A File object pointing to your GeoLite2 ASN database

        File database = new File("src/main/resources/GeoLite2-ASN.mmdb");

// This creates the DatabaseReader object. To improve performance, reuse
// the object across lookups. The object is thread-safe.
        DatabaseReader reader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName(ip);

        AsnResponse response = reader.asn(ipAddress);

        System.out.println(response.getAutonomousSystemNumber());       // 217
        System.out.println(response.getAutonomousSystemOrganization()); // 'University of Minnesota'
    }

    private static void city(String ip) throws IOException, GeoIp2Exception {
        // A File object pointing to your GeoIP2 or GeoLite2 database
        File database = new File("src/main/resources/GeoLite2-City.mmdb");

// This creates the DatabaseReader object. To improve performance, reuse
// the object across lookups. The object is thread-safe.
        DatabaseReader reader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName(ip);

// Replace "city" with the appropriate method for your database, e.g.,
// "country".
        CityResponse response = reader.city(ipAddress);

        Country country = response.getCountry();
        System.out.println(country.getIsoCode());            // 'US'
        System.out.println(country.getName());               // 'United States'
        System.out.println(country.getNames().get("zh-CN")); // '美国'

        Subdivision subdivision = response.getMostSpecificSubdivision();
        System.out.println(subdivision.getName());    // 'Minnesota'
        System.out.println(subdivision.getNames().get("zh-CN"));
        System.out.println(subdivision.getIsoCode()); // 'MN'

        City city = response.getCity();
        System.out.println(city.getName()); // 'Minneapolis'
        System.out.println(city.getNames().get("zh-CN"));

        Postal postal = response.getPostal();
        System.out.println(postal.getCode()); // '55455'

        Location location = response.getLocation();
        System.out.println(location.getLatitude());  // 44.9733
        System.out.println(location.getLongitude()); // -93.2323
    }

}
