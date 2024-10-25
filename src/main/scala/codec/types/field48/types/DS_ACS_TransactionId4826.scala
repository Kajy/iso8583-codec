package codec.types.field48.types

import codec.FieldCodecs.LLVAR
import codec.types.field48.PrivateData48XX
import scodec.Codec
import scodec.codecs.ascii
import scodec.TransformSyntax

case class DS_ACS_TransactionId4826(id: String) extends PrivateData48XX

object DS_ACS_TransactionId4826 {
  // TODO: What is the truth: typed (ANS) but example is encoded in ascii ???
  // val codec: Codec[DS_ACS_TransactionId4826] = LLVAR_ANS.as[DS_ACS_TransactionId4826]
  val codec: Codec[DS_ACS_TransactionId4826] = LLVAR(ascii).as[DS_ACS_TransactionId4826]
}
