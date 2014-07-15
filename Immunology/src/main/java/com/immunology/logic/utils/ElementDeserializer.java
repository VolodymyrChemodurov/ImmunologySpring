package com.immunology.logic.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.immunology.model.ui.Element;
import com.immunology.model.ui.elements.TextBox;

public class ElementDeserializer extends JsonDeserializer<Set<Element>> {

	@Override
	public Set<Element> deserialize(JsonParser jsonParser,
			DeserializationContext arg1) throws IOException,
			JsonProcessingException {

		Set<Element> tbs = new HashSet<Element>();
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		Iterator<JsonNode> iterator = node.elements();
		while(iterator.hasNext()) {
			TextBox tb = new TextBox();
			JsonNode innerNode = iterator.next();
			String name = innerNode.get("name").asText();
			int place = (Integer)((IntNode) innerNode.get("place")).numberValue();
			boolean checked = (Boolean)((BooleanNode) innerNode.get("checked")).booleanValue();
			tb.setName(name);
			tb.setChecked(checked);
			tb.setPlace(place);
			tbs.add(tb);
		}
		return tbs;
	}

}
