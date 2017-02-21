# slascala-emoji-client
Slack Emoji Client for Scala

## Usage

### Upload Emoji to your team slack
```scala
val yourTeamName = "xxxxxxxx"
val slackCookie = "yyyyyyyy"
val emojiClient = new SlascalaEmojiClient(yourTeamName, slackCookie)

emojiClient.upload("nameOfEmojiToUpload", new File("emojiImageFile")) match {
  case Left(e)  => // failed to upload emoji
  case Right(_) => // Success!
}
```

### Cookie?
slascala-emoji-client uses Cookie of slack page to upload custom emoji.
To capture,

1. Access https://{yourTeamName}.slack.com/customize/emoji
2. Open developper tool
3. Input `document.cookie` to JavaScript console
4. Copy result

## Loadmap
- Deletion by name
- Export all regestered emoji
- Bulk upload
- Update Emoji
