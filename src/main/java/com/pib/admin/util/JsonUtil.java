package com.pib.admin.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pib.admin.entity.Account; 

public class JsonUtil {

	public static Account getUserByGoogleAccount(String jsonstr) {
		JsonObject jsonObject = new Gson().fromJson(jsonstr, JsonObject.class);
		JsonObject data = jsonObject.get("data").getAsJsonObject();
		data.get("username");
		Account e = new Account.Builder()
				.set("id", 1L)
				.set("username", data.get("username").getAsString())
				.set("email", data.get("email").getAsString())
				.set("nickname", data.get("nickname")==null ? "":data.get("nickname").getAsString() )
				.set("company", data.get("company")==null ? "":data.get("company").getAsString() )
				.set("imgsrc", data.get("avatar")==null ? "":data.get("avatar").getAsString() )
				.set("company", data.get("company")==null ? "":data.get("company").getAsString() )
				.set("location", data.get("location") == null ? "" : data.get("location").getAsString())
				.set("gender", data.get("gender") == null ? "" : data.get("gender").getAsString())
				.set("source", data.get("source") == null ? "" : data.get("source").getAsString())
				.set("remark", data.get("remark") == null ? "" : data.get("remark").getAsString())
				.build();
		return e;
	}
}
