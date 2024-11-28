package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class DeviceType4813(device: DeviceType4813.Device) extends PrivateData48XX

object DeviceType4813 {
  sealed abstract class Device(val value: String) extends StringEnumEntry

  object Device extends StringEnum[Device] {
    val values = findValues

    case object CARD              extends Device("20")
    case object PHONE             extends Device("21")
    case object TABLET            extends Device("22")
    case object SMART_WATCH       extends Device("23")
    case object STICKER           extends Device("24")
    case object PC                extends Device("25")
    case object PERIPHERAL        extends Device("26")
    case object TAG               extends Device("27")
    case object JEWEL             extends Device("28")
    case object FASHION_ACCESSORY extends Device("29")
    case object CLOTHING          extends Device("30")
    case object HOME_AUTOMATION   extends Device("31")
    case object VEHICLE           extends Device("32")
    case object MEDIA_GAMING      extends Device("33")
    case object VIRTUAL_REALITY   extends Device("34")
    case object OTHER             extends Device("00")

    val mapping = Device.valuesToEntriesMap.map(_.swap)
    val codec   = "Device" | mappedEnum(N, mapping)
  }

  val codec: Codec[DeviceType4813] = LLVAR_N(Device.codec).as[DeviceType4813]
}
