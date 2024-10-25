package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class ATMServiceFee4828(amount: String) extends PrivateData48XX

object ATMServiceFee4828 {
  val codec: Codec[ATMServiceFee4828] = LLVAR_N.as[ATMServiceFee4828]
}
