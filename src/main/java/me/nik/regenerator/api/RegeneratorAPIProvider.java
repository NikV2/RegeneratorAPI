package me.nik.regenerator.api;

public class RegeneratorAPIProvider {

    private static RegeneratorAPI API = null;

    public RegeneratorAPIProvider() {
    }

    public static RegeneratorAPI getAPI() {
        return API;
    }

    /**
     * Internal use by Regenerator only!
     *
     * @param api RegeneratorAPI
     */
    @Deprecated
    public static void register(RegeneratorAPI api) {
        API = api;
    }
}