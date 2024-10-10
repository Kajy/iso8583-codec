package codec.types.field46.field3

import codec.FieldCodecs.{LLVAR, N}
import codec.types.WalletInfos46XX
import codec.types.field46.field3.types._
import scodec.Codec
import scodec.codecs.{discriminated, list}

trait DeviceData4603XX

case class DeviceData4603(
    serialNumber01: Option[SerialNumber460301],
    name02: Option[Name460302],
    type03: Option[Type460303],
    osType04: Option[OSType460304],
    osIdentifier05: Option[OSIdentifier460305],
    languageCode06: Option[LanguageCode460306],
    ipAddress07: Option[IPAddress460307],
    location08: Option[Location460308],
    deviceTrustScore09: Option[DeviceTrustScore460309],
    hardwareIdentifier10: Option[HardwareIdentifier460310],
    bluetoothMacAddress11: Option[BluetoothMacAddress460311],
    deviceTimezone12: Option[DeviceTimezone460312],
    timezoneConfiguration13: Option[TimezoneConfiguration460313],
    deviceNumber14: Option[DeviceNumber460314],
    storageTechnology15: Option[StorageTechnology460315],
    lastDigits16: Option[PhoneLastDigits460316]
) extends WalletInfos46XX

object DeviceData4603 {
  private val subFieldsCodec: Codec[DeviceData4603XX] =
    discriminated[DeviceData4603XX]
      .by(N(2))
      .typecase("01", SerialNumber460301.codec)
      .typecase("02", Name460302.codec)
      .typecase("03", Type460303.codec)
      .typecase("04", OSType460304.codec)
      .typecase("05", OSIdentifier460305.codec)
      .typecase("06", LanguageCode460306.codec)
      .typecase("07", IPAddress460307.codec)
      .typecase("08", Location460308.codec)
      .typecase("09", DeviceTrustScore460309.codec)
      .typecase("10", HardwareIdentifier460310.codec)
      .typecase("11", BluetoothMacAddress460311.codec)
      .typecase("12", DeviceTimezone460312.codec)
      .typecase("13", TimezoneConfiguration460313.codec)
      .typecase("14", DeviceNumber460314.codec)
      .typecase("15", StorageTechnology460315.codec)
      .typecase("16", PhoneLastDigits460316.codec)

  val codec: Codec[DeviceData4603] = LLVAR(list(subFieldsCodec))
    .xmap(
      fields => {
        val sn01 = fields.collectFirst({ case t: SerialNumber460301 => t })
        val n02 = fields.collectFirst({ case t: Name460302 => t })
        val t03 = fields.collectFirst({ case t: Type460303 => t })
        val ost04 = fields.collectFirst({ case t: OSType460304 => t })
        val osi05 = fields.collectFirst({ case t: OSIdentifier460305 => t })
        val lc06 = fields.collectFirst({ case t: LanguageCode460306 => t })
        val ipaddr07 = fields.collectFirst({ case t: IPAddress460307 => t })
        val l08 = fields.collectFirst({ case t: Location460308 => t })
        val dts09 = fields.collectFirst({ case t: DeviceTrustScore460309 => t })
        val hid10 = fields.collectFirst({ case t: HardwareIdentifier460310 =>
          t
        })
        val bma11 = fields.collectFirst({ case t: BluetoothMacAddress460311 =>
          t
        })
        val dt12 = fields.collectFirst({ case t: DeviceTimezone460312 => t })
        val tc13 = fields.collectFirst({ case t: TimezoneConfiguration460313 =>
          t
        })
        val dn14 = fields.collectFirst({ case t: DeviceNumber460314 => t })
        val st15 = fields.collectFirst({ case t: StorageTechnology460315 => t })
        val pld16 = fields.collectFirst({ case t: PhoneLastDigits460316 => t })
        DeviceData4603(
          sn01,
          n02,
          t03,
          ost04,
          osi05,
          lc06,
          ipaddr07,
          l08,
          dts09,
          hid10,
          bma11,
          dt12,
          tc13,
          dn14,
          st15,
          pld16
        )
      },
      dd =>
        List.concat(
          dd.serialNumber01,
          dd.name02,
          dd.type03,
          dd.osType04,
          dd.osIdentifier05,
          dd.languageCode06,
          dd.ipAddress07,
          dd.location08,
          dd.deviceTrustScore09,
          dd.hardwareIdentifier10,
          dd.bluetoothMacAddress11,
          dd.deviceTimezone12,
          dd.timezoneConfiguration13,
          dd.deviceNumber14,
          dd.storageTechnology15,
          dd.lastDigits16
        )
    )
}