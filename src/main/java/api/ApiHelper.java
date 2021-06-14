package api;

import base.BasePage;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

public class ApiHelper {
    public static JsonObject login() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"token\":\"\",\"email\":\"amosh.armenakyan@gmail.com\",\"password\":\"Amosh2002\",\"twoFactorEnabled\":false}");
            Request request = new Request.Builder()
                    .url("https://api.name.am/auth/login")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cookie", "token=Bearer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJoYXZlQ29udGFjdEluZm8iOmZhbHNlLCJmaXJzdE5hbWUiOiJBcm1lbiIsImxhc3ROYW1lIjoiQXJtZW5ha3lhbiIsImZ1bGxOYW1lIjoiQXJtZW4gQXJtZW5ha3lhbiIsInZlcmlmaWVkIjpmYWxzZSwibG9jYWxlIjoiaHkiLCJlbWFpbCI6ImFtb3NoLmFybWVuYWt5YW5AZ21haWwuY29tIiwicm9sZSI6MiwiaWQiOiI2MGM3MGU1N2U5MGM5NTYzYmFmNWQxZTIiLCJpYXQiOjE2MjM2NTgyNzksImV4cCI6MjIzMTY1ODI3OX0.9k6B6DSkjFsMNcddJudWnFBKfNHeZimlxJkxBUySIrc")
                    .build();
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            return JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (Exception E) {
            BasePage.LOGGER.info("API Login failed");
            System.exit(0);
        }
        return null;
    }

    public static JsonObject checkDomainAvailability() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "[{\"tld\":\"actor\",\"loading\":true,\"main\":true,\"domain\":\"testingpics.actor\"}]");
            Request request = new Request.Builder()
                    .url("https://api.name.am/client/domains/check")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cookie", "token=Bearer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJoYXZlQ29udGFjdEluZm8iOmZhbHNlLCJmaXJzdE5hbWUiOiJBcm1lbiIsImxhc3ROYW1lIjoiQXJtZW5ha3lhbiIsImZ1bGxOYW1lIjoiQXJtZW4gQXJtZW5ha3lhbiIsInZlcmlmaWVkIjpmYWxzZSwibG9jYWxlIjoiaHkiLCJlbWFpbCI6ImFtb3NoLmFybWVuYWt5YW5AZ21haWwuY29tIiwicm9sZSI6MiwiaWQiOiI2MGM3MGU1N2U5MGM5NTYzYmFmNWQxZTIiLCJpYXQiOjE2MjM2NTgyNzksImV4cCI6MjIzMTY1ODI3OX0.9k6B6DSkjFsMNcddJudWnFBKfNHeZimlxJkxBUySIrc")
                    .build();
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            jsonString = jsonString.substring(1, jsonString.length() - 1);
            return JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (Exception E) {
            BasePage.LOGGER.info("API check domain availability failed");
            System.exit(0);
        }
        return null;
    }

    public static JsonObject sendDomainToCart() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "[{\"type\":\"domain_registration\",\"domain\":\"testingpics.actor\"}]");
            Request request = new Request.Builder()
                    .url("https://api.name.am/client/carts/60c70e17e90c9563baf5d1df")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cookie", "token=Bearer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJoYXZlQ29udGFjdEluZm8iOmZhbHNlLCJmaXJzdE5hbWUiOiJBcm1lbiIsImxhc3ROYW1lIjoiQXJtZW5ha3lhbiIsImZ1bGxOYW1lIjoiQXJtZW4gQXJtZW5ha3lhbiIsInZlcmlmaWVkIjpmYWxzZSwibG9jYWxlIjoiaHkiLCJlbWFpbCI6ImFtb3NoLmFybWVuYWt5YW5AZ21haWwuY29tIiwicm9sZSI6MiwiaWQiOiI2MGM3MGU1N2U5MGM5NTYzYmFmNWQxZTIiLCJpYXQiOjE2MjM2NTgyNzksImV4cCI6MjIzMTY1ODI3OX0.9k6B6DSkjFsMNcddJudWnFBKfNHeZimlxJkxBUySIrc")
                    .build();
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            return JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (Exception E) {
            BasePage.LOGGER.info("API send domain to cart failed");
            System.exit(0);
        }
        return null;
    }
}
