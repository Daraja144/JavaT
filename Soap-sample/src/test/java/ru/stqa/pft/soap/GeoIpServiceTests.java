package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    String countryName = new GeoIPService().getGeoIPServiceSoap12().getCountryNameByISO2("192.168.43.97");
    Assert.assertEquals(countryName, "<GeoIP><Country>UNITED STATES</Country></GeoIP>");
  }

  @Test
  public void testInvalidIp() {
    String countryNameByISO2 = new GeoIPService().getGeoIPServiceSoap12().getCountryNameByISO2("xxx.xxx.xx.xx");
    Assert.assertEquals(countryNameByISO2, "<GeoIP><Country>UNITED STATES</Country></GeoIP>");
  }
}
