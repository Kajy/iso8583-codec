package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class ATMDisloyaltyFee4829(amount: String) extends PrivateData48XX

object ATMDisloyaltyFee4829 {
  val codec: Codec[ATMDisloyaltyFee4829] = LLVAR_N.as[ATMDisloyaltyFee4829]
}
