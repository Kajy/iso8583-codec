package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class ATMServiceFee4828(amount: Long) extends PrivateData48XX

object ATMServiceFee4828 {
  val codec: Codec[ATMServiceFee4828] = TLV_N(12).as[ATMServiceFee4828]
}
