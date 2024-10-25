package codec.types.field48.types

import codec.FieldCodecs.{ LLVAR_N, N }
import codec.types.field48.PrivateData48XX
import enumeratum.values.*
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }

case class ECommerceAuthentificationFlag4824(
    flag: ECommerceAuthentificationFlag4824.AuthentificationFlag
) extends PrivateData48XX

object ECommerceAuthentificationFlag4824 {
  sealed abstract class AuthentificationFlag(val value: String) extends StringEnumEntry

  object AuthentificationFlag extends StringEnum[AuthentificationFlag] {
    val values = findValues

    case object TRANSACTION_NOT_SECURE extends AuthentificationFlag("00")
    case object CARRIER_NOT_AUTH       extends AuthentificationFlag("01")
    case object ATTEMPT                extends AuthentificationFlag("02")
    case object FULLY_AUTH             extends AuthentificationFlag("03")
    case object SPECIAL_MCD_PROGRAMS   extends AuthentificationFlag("04")
    case object MERCHANT_RBA_DECISION  extends AuthentificationFlag("05")
    case object RECURRING_PAYMENT      extends AuthentificationFlag("06")
    case object ID_CHECK_INSIGHTS      extends AuthentificationFlag("07")
    case object UNKNOWN                extends AuthentificationFlag("99")

    val mapping = AuthentificationFlag.valuesToEntriesMap.map(_.swap)
    val codec   = "AuthentificationFlag" | mappedEnum(N, mapping)
  }

  val codec: Codec[ECommerceAuthentificationFlag4824] =
    LLVAR_N(AuthentificationFlag.codec).as[ECommerceAuthentificationFlag4824]

}
