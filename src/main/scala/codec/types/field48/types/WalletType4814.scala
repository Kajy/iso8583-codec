package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class WalletType4814(`type`: WalletType4814.WalletType) extends PrivateData48XX

object WalletType4814 {
  sealed abstract class WalletType(val value: String) extends StringEnumEntry

  object WalletType extends StringEnum[WalletType] {
    val values = findValues

    case object UNKNOWN                       extends WalletType("0000")
    case object MASTERPASS                    extends WalletType("0101")
    case object APPLE_PAY                     extends WalletType("0103")
    case object GOOGLE_PAY                    extends WalletType("0216")
    case object SAMSUNG_PAY                   extends WalletType("0217")
    case object MERCHANT_TOKENIZATION_PROGRAM extends WalletType("0327")

    val mapping = WalletType.valuesToEntriesMap.map(_.swap)
    val codec   = "WalletType" | mappedEnum(N, mapping)
  }

  val codec: Codec[WalletType4814] = LLVAR_N(WalletType.codec).as[WalletType4814]
}
