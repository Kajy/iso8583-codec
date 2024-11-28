package codec.types.field48.types

import codec.FieldCodecs.{LLVAR, LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import codec.types.field48.types.FraudType484302.FraudType
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class AdditionalFraudData4843(
    fraudRuleReference01: Option[FraudRuleReference484301],
    fraudType02: Option[FraudType484302]
) extends PrivateData48XX

object AdditionalFraudData4843 {

  private val subFieldCodec =
    discriminated[AdditionalFraudData4843XX]
      .by(N(2))
      .typecase("01", "FraudRuleReference01" | FraudRuleReference484301.codec)
      .typecase("02", "FraudType02" | FraudType484302.codec)

  val codec: Codec[AdditionalFraudData4843] = LLVAR(
    list(subFieldCodec).xmap(
      fields =>
        AdditionalFraudData4843(
          fields.collectFirst { case t: FraudRuleReference484301 => t },
          fields.collectFirst { case t: FraudType484302 => t }
        ),
      afd =>
        List.concat(
          afd.fraudRuleReference01,
          afd.fraudType02
        )
    )
  )

}

trait AdditionalFraudData4843XX

case class FraudRuleReference484301(reference: String) extends AdditionalFraudData4843XX

object FraudRuleReference484301 {
  val codec: Codec[FraudRuleReference484301] = LLVAR_N.as[FraudRuleReference484301]
}

case class FraudType484302(`type`: FraudType) extends AdditionalFraudData4843XX

object FraudType484302 {

  sealed abstract class FraudType(val value: String) extends StringEnumEntry

  object FraudType extends StringEnum[FraudType] {
    val values = findValues

    case object RESERVED_00                       extends FraudType("00")
    case object MERCHANT_COUNTRY_UNDER_MONITORING extends FraudType("01")
    case object MERCHANT_ID_UNDER_MONITORING      extends FraudType("02")
    case object RESERVED_03                       extends FraudType("03")
    case object RESERVED_04                       extends FraudType("04")
    case object RESERVED_05                       extends FraudType("05")
    case object RESERVED_06                       extends FraudType("06")
    case object RESERVED_07                       extends FraudType("07")
    case object RESERVED_08                       extends FraudType("08")
    case object RESERVED_09                       extends FraudType("09")
    case object RESERVED_10                       extends FraudType("10")
    case object CARD_GLOBAL_RED_LIST              extends FraudType("11")
    case object CARD_COUNTRY_RED_LIST             extends FraudType("12")
    case object CARD_MCC_RED_LIST                 extends FraudType("13")
    case object RESERVED_14                       extends FraudType("14")
    case object RESERVED_15                       extends FraudType("15")
    case object RESERVED_16                       extends FraudType("16")
    case object RESERVED_17                       extends FraudType("17")
    case object RESERVED_18                       extends FraudType("18")
    case object RESERVED_19                       extends FraudType("19")
    case object RESERVED_20                       extends FraudType("20")
    case object CARD_GLOBAL_GREEN_LIST            extends FraudType("21")
    case object CARD_COUNTRY_GREEN_LIST           extends FraudType("22")
    case object CARD_MCC_GREEN_LIST               extends FraudType("23")
    case object RESERVED_24                       extends FraudType("24")
    case object RESERVED_25                       extends FraudType("25")
    case object RESERVED_26                       extends FraudType("26")
    case object RESERVED_27                       extends FraudType("27")
    case object RESERVED_28                       extends FraudType("28")
    case object RESERVED_29                       extends FraudType("29")
    case object RESERVED_30                       extends FraudType("30")
    case object RESERVED_31                       extends FraudType("31")
    case object RESERVED_32                       extends FraudType("32")
    case object RESERVED_33                       extends FraudType("33")
    case object RESERVED_34                       extends FraudType("34")
    case object RESERVED_35                       extends FraudType("35")
    case object RESERVED_36                       extends FraudType("36")
    case object RESERVED_37                       extends FraudType("37")
    case object RESERVED_38                       extends FraudType("38")
    case object RESERVED_39                       extends FraudType("39")
    case object RESERVED_40                       extends FraudType("40")
    case object RESERVED_41                       extends FraudType("41")
    case object RESERVED_42                       extends FraudType("42")
    case object RESERVED_43                       extends FraudType("43")
    case object RESERVED_44                       extends FraudType("44")
    case object RESERVED_45                       extends FraudType("45")
    case object RESERVED_46                       extends FraudType("46")
    case object RESERVED_47                       extends FraudType("47")
    case object RESERVED_48                       extends FraudType("48")
    case object RESERVED_49                       extends FraudType("49")
    case object RESERVED_50                       extends FraudType("50")
    case object RESERVED_51                       extends FraudType("51")
    case object RESERVED_52                       extends FraudType("52")
    case object RESERVED_53                       extends FraudType("53")
    case object RESERVED_54                       extends FraudType("54")
    case object RESERVED_55                       extends FraudType("55")
    case object RESERVED_56                       extends FraudType("56")
    case object RESERVED_57                       extends FraudType("57")
    case object RESERVED_58                       extends FraudType("58")
    case object RESERVED_59                       extends FraudType("59")
    case object RESERVED_60                       extends FraudType("60")
    case object RESERVED_61                       extends FraudType("61")
    case object RESERVED_62                       extends FraudType("62")
    case object RESERVED_63                       extends FraudType("63")
    case object RESERVED_64                       extends FraudType("64")
    case object RESERVED_65                       extends FraudType("65")
    case object RESERVED_66                       extends FraudType("66")
    case object RESERVED_67                       extends FraudType("67")
    case object RESERVED_68                       extends FraudType("68")
    case object RESERVED_69                       extends FraudType("69")
    case object RESERVED_70                       extends FraudType("70")
    case object RESERVED_71                       extends FraudType("71")
    case object RESERVED_72                       extends FraudType("72")
    case object RESERVED_73                       extends FraudType("73")
    case object RESERVED_74                       extends FraudType("74")
    case object RESERVED_75                       extends FraudType("75")
    case object RESERVED_76                       extends FraudType("76")
    case object RESERVED_77                       extends FraudType("77")
    case object RESERVED_78                       extends FraudType("78")
    case object RESERVED_79                       extends FraudType("79")
    case object RESERVED_80                       extends FraudType("80")
    case object RESERVED_81                       extends FraudType("81")
    case object RESERVED_82                       extends FraudType("82")
    case object RESERVED_83                       extends FraudType("83")
    case object RESERVED_84                       extends FraudType("84")
    case object RESERVED_85                       extends FraudType("85")
    case object RESERVED_86                       extends FraudType("86")
    case object RESERVED_87                       extends FraudType("87")
    case object RESERVED_88                       extends FraudType("88")
    case object RESERVED_89                       extends FraudType("89")
    case object RESERVED_90                       extends FraudType("90")
    case object RESERVED_91                       extends FraudType("91")
    case object RESERVED_92                       extends FraudType("92")
    case object RESERVED_93                       extends FraudType("93")
    case object RESERVED_94                       extends FraudType("94")
    case object RESERVED_95                       extends FraudType("95")
    case object RESERVED_96                       extends FraudType("96")
    case object RESERVED_97                       extends FraudType("97")
    case object RESERVED_98                       extends FraudType("98")
    case object RESERVED_99                       extends FraudType("99")

    val mapping = FraudType.valuesToEntriesMap.map(_.swap)
    val codec   = "FraudType" | mappedEnum(N, mapping)
  }

  val codec: Codec[FraudType484302] = LLVAR_N(FraudType.codec).as[FraudType484302]
}
