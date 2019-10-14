package com.tws.refactoring.extract_variable;

public class BannerRender {

    private static final String BANNER = "banner";
    private static final String IE_ON_MAC = "IE on Mac?";

    public String renderBanner(String platform, String browser) {
        if (isPlatformMAC(platform) && isBrowserIE(browser)) {
            return IE_ON_MAC;
        }
        return BANNER;
    }

    private boolean isPlatformMAC(String platform){
        return platform.toUpperCase().contains("MAC");
    }

    private boolean isBrowserIE(String browser){
        return browser.toUpperCase().contains("IE");
    }
}
