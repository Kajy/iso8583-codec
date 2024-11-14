package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class ATMDisloyaltyFee4829(amount: Long) extends PrivateData48XX

object ATMDisloyaltyFee4829 {
  val codec: Codec[ATMDisloyaltyFee4829] = TLV_N(12).as[ATMDisloyaltyFee4829]
}
