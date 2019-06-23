package org.sidiff.graphpattern.profile.henshin_extension.converter;

import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.converter.GraphPatternToHenshinConverter;
import org.sidiff.graphpattern.profile.henshin.converter.GraphPatternToHenshinConverterHandler;

public class GraphPatternToHenshinExtensionConverterHandler extends GraphPatternToHenshinConverterHandler {

	@Override
	protected GraphPatternToHenshinConverter createConverter(Pattern editOperation) {
		return new GraphPatternToHenshinExtensionConverter(editOperation);
	}
}
