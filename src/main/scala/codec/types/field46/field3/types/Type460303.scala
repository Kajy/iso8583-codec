package codec.types.field46.field3.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.WalletData4602XX
import codec.types.field46.field3.DeviceData4603XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs.{mappedEnum, StringEnrichedWithCodecContextSupport}

case class Type460303(
    `type`: Type460303.Type
) extends DeviceData4603XX

object Type460303 {
  sealed abstract class Type(val value: String) extends StringEnumEntry

  object Type extends StringEnum[Type] {
    val values: IndexedSeq[Type] = findValues

    case object UNDEFINED_VISA extends Type("00")
    case object PHONE extends Type("01")
    case object TABLET_VISA extends Type("02")
    case object WATCH_VISA extends Type("03")
    case object MOBILE_PHONE_TABLET_VISA extends Type("04")
    case object PC extends Type("05")
    case object TABLET_EREADER_MCD extends Type("06")
    case object WATCH_MCD extends Type("07")
    case object CARD_MCD extends Type("08")
    case object STICKER_MCD extends Type("09")
    case object DEVICE_PERIPHERAL_MCD extends Type("10")
    case object TAG_MCD extends Type("11")
    case object JEWELRY_MCD extends Type("12")
    case object FASHION_ACCESSORY_MCD extends Type("13")
    case object GARMENT_MCD extends Type("14")
    case object DOMESTIC_APPLIANCE_MCD extends Type("15")
    case object VEHICLE_MCD extends Type("16")
    case object MEDIA_DEVICE_MCD extends Type("17")
    case object VR_HEADSET_MCD extends Type("18")

    val mapping: Map[Type, String] =
      Type.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[Type460303] = "Type" | LLVAR(
    mappedEnum(AN, Type.mapping)
  ).as[Type460303]
}
