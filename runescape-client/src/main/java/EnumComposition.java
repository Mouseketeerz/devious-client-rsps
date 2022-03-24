import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("EnumComposition")
public class EnumComposition extends DualNode {
	@ObfuscatedName("o")
	@ObfuscatedSignature(descriptor = 
	"Liq;")

	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("m")
	@ObfuscatedSignature(descriptor = 
	"[[Lkn;")

	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("iq")
	@ObfuscatedGetter(intValue = 
	1021472065)

	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("h")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("g")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("l")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("n")
	@ObfuscatedGetter(intValue = 
	345435135)

	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("d")
	@ObfuscatedGetter(intValue = 
	123601371)

	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("f")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("u")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("r")
	@Export("strVals")
	public String[] strVals;
	static 
	{
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumComposition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(descriptor = 
	"(Lpd;I)V", garbageValue = 
	"-701511419")

	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		} 
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(descriptor = 
	"(Lpd;IB)V", garbageValue = 
	"1")

	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.inputType = ((char) (var1.readUnsignedByte()));
		} else if (var2 == 2) {
			this.outputType = ((char) (var1.readUnsignedByte()));
		} else if (var2 == 3) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.defaultInt = var1.readInt();
		} else {
			int var3;
			if (var2 == 5) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.strVals = new String[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.strVals[var3] = var1.readStringCp1252NullTerminated();
				}
			} else if (var2 == 6) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.intVals = new int[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.intVals[var3] = var1.readInt();
				}
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(descriptor = 
	"(I)I", garbageValue = 
	"-1309113097")

	@Export("size")
	public int size() {
		return this.outputCount;
	}
}