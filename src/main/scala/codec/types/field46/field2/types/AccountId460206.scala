package codec.types.field46.field2.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field46.field2.WalletData4602XX
import scodec.{Codec, TransformSyntax}

case class AccountId460206(id: String) extends WalletData4602XX

object AccountId460206 {
  val codec: Codec[AccountId460206] = LLVAR_AN.as[AccountId460206]
}
