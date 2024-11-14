package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import codec.types.field48.types.ECommerceAuthentificationType4855.ECommerceAuthentificationType
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class ECommerceAuthentificationType4855(`type`: ECommerceAuthentificationType) extends PrivateData48XX

object ECommerceAuthentificationType4855 {
  sealed abstract class ECommerceAuthentificationType(val value: String) extends StringEnumEntry

  object ECommerceAuthentificationType extends StringEnum[ECommerceAuthentificationType] {
    val values = findValues

    case object CARDHOLDER_NOT_AUTH extends ECommerceAuthentificationType("00")
    case object STRONG_AUTH         extends ECommerceAuthentificationType("01")
    case object FRICTIONLESS        extends ECommerceAuthentificationType("02")
    case object EXEMPTION           extends ECommerceAuthentificationType("03")

    val mapping = ECommerceAuthentificationType.valuesToEntriesMap.map(_.swap)
    val codec   = "ECommerceAuthentificationType" | mappedEnum(N, mapping)
  }

  val codec: Codec[ECommerceAuthentificationType4855] = LLVAR_N(ECommerceAuthentificationType.codec).as[ECommerceAuthentificationType4855]
}
