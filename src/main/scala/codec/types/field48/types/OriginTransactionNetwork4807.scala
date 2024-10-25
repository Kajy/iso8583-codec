package codec.types.field48.types

import codec.FieldCodecs.{ LLVAR_N, N }
import codec.types.field48.PrivateData48XX
import enumeratum.values.{ StringEnum, StringEnumEntry }
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }

case class OriginTransactionNetwork4807(network: OriginTransactionNetwork4807.Network)
    extends PrivateData48XX

object OriginTransactionNetwork4807 {
  sealed abstract class Network(val value: String) extends StringEnumEntry

  object Network extends StringEnum[Network] {
    val values = findValues

    case object eRSB       extends Network("00")
    case object MASTERCARD extends Network("01")
    case object VISA       extends Network("02")
    case object BANCONTACT extends Network("03")

    val mapping = Network.valuesToEntriesMap.map(_.swap)
    val codec   = "Network" | mappedEnum(N, mapping)
  }

  val codec: Codec[OriginTransactionNetwork4807] =
    LLVAR_N(Network.codec).as[OriginTransactionNetwork4807]

}
