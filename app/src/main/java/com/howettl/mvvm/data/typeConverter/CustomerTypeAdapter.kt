//package com.webkul.mobikul.pos.db.converters
//
//import com.google.gson.Gson
//import com.google.gson.TypeAdapter
//import com.google.gson.reflect.TypeToken
//import com.google.gson.stream.JsonToken
//import com.webkul.mobikul.pos.db.entity.Customer
//import com.webkul.mobikul.pos.db.entity.FloorModel
//import com.webkul.mobikul.pos.db.entity.Tax
//import com.webkul.mobikul.pos.model.Extras
//import com.webkul.mobikul.pos.model.Tables
//
//class CustomerTypeAdapter : TypeAdapter<List<Customer>?>() {
//
//
//    override fun read(reader: com.google.gson.stream.JsonReader?): List<Customer>? {
//        reader?.beginArray()
//        val authors: ArrayList<Customer> = ArrayList()
//        while (reader?.hasNext() == true) {
//            var data = Customer()
//
//            when (reader.peek()) {
//                JsonToken.BEGIN_OBJECT -> {
//                    reader.beginObject()
//                    while (reader.hasNext()) {
//                        when (reader.nextName()) {
//                            "customerId" -> data.customerId = (reader.nextInt());
//                            "customer_first_name" -> data.firstName = (reader.nextString());
//                            "customer_last_name" -> data.lastName = (reader.nextString());
//                            "contact_number" -> data.contactNumber = (reader.nextString());
//                            "address_line" -> data.addressLine = (reader.nextString());
//                            "city" -> data.city = (reader.nextString());
//                            "postal_code" -> data.postalCode = (reader.nextString());
//                            "email" -> data.email = (reader.nextString());
//                            "state" -> data.state = (reader.nextString());
//                            "country" -> data.country = (reader.nextString());
//                            "credit_limit" -> data.creditLimit = (reader.nextString());
//                            "credit_balance" -> data.creditBalance = (reader.nextString());
//                            "extras" -> {
//                                var dataStri = reader?.nextString()
//                                if (dataStri.equals("")==false && dataStri.equals("[]")==false) {
//                                    if (dataStri.equals("") || dataStri.equals("[]")) dataStri = "{}"
//                                    val gson = Gson()
//                                    val type = object : TypeToken<Extras>() {}.type
//                                    val dataa: Extras = gson.fromJson(dataStri, type)
//                                    data.extras = (dataa);
//                                }
//                            }
//
//
//                        }
//                    }
//                    authors.add(data)
//                    reader.endObject()
//                }
//            }
//
//        }
//        reader?.endArray()
//        return authors
//
//    }
//
//    override fun write(out: com.google.gson.stream.JsonWriter?, value: List<Customer>?) {
//
//    }
//}
