package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    GeoIPService geoIPService = new GeoIPService.GeoIPServiceSoap12().getCountryNameByISO2("192.168.43.97");

    Assert.assertEquals();

  }
}
