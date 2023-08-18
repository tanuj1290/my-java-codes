from gtts import gTTS
from io import BytesIO

mp3_fp = BytesIO()
print(type(mp3_fp))
tts = gTTS('hello', lang='en')
print(type(tts))
tts.write_to_fp(mp3_fp)
print(type(mp3_fp))
# return this to the client side.
# return mp3_fp