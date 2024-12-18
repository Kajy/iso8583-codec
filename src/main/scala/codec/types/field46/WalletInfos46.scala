package codec.types

import codec.FieldCodecs.*
import codec.types.field46.field1.TokenData4601
import codec.types.field46.field2.WalletData4602
import codec.types.field46.field3.DeviceData4603
import codec.types.field46.field4.OtherData4604
import scodec.Codec
import scodec.codecs.*

trait WalletInfos46XX

// 46
case class WalletInfos46(
    tokenData01: Option[TokenData4601],
    walletData02: Option[WalletData4602],
    deviceData03: Option[DeviceData4603],
    otherData04: Option[OtherData4604]
) {

  override def toString: String =
    f"""
       |tokenData01: ${tokenData01},
       |walletData4602: ${walletData02}
       |deviceData4603: ${deviceData03}
       |otherData04: ${otherData04}
       |""".stripMargin

}

object WalletInfos46 {

  private val subFieldsCodec: Codec[WalletInfos46XX] =
    discriminated[WalletInfos46XX]
      .by(N(2))
      .typecase("01", "TokenData01" | TokenData4601.codec)
      .typecase("02", "WalletData02" | WalletData4602.codec)
      .typecase("03", "DeviceData03" | DeviceData4603.codec)
      .typecase("04", "OtherData04" | OtherData4604.codec)

  val codec: Codec[WalletInfos46] = LLLVAR(
    list(subFieldsCodec).xmap(
      fields =>
        WalletInfos46(
          fields.collectFirst { case t: TokenData4601 => t },
          fields.collectFirst { case t: WalletData4602 => t },
          fields.collectFirst { case t: DeviceData4603 => t },
          fields.collectFirst { case t: OtherData4604 => t }
        ),
      wd =>
        List.concat(
          wd.tokenData01,
          wd.walletData02,
          wd.deviceData03,
          wd.otherData04
        )
    )
  )

}
