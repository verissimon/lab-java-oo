package dominio;

import java.util.*;

public class Dev {
    private String name;
    private Set<Content> subscribedContent = new LinkedHashSet<>();
    private Set<Content> finishedContent = new LinkedHashSet<>();

    public void subscribeToBootcamp(Bootcamp bootcamp) {
        this.subscribedContent.addAll(bootcamp.getContents());
        bootcamp.getSubscribedDevs().add(this);
    }

    public void progress() {
        Optional<Content> content = this.subscribedContent.stream().findFirst();

        content.ifPresentOrElse(value -> {
            this.subscribedContent.remove(value);
            this.finishedContent.add(value);
        }, () -> System.err.println("There is no subscribed content to progress."));
    }

    public double calculateTotalExp() {
        return this.finishedContent
                .stream()
                .mapToDouble(Content::calculateExp)
                .sum();
    }

    public void showSubscribedContent() {
        System.out.println("------------------");
        System.out.println("content subscribed by " + this.getName() + "\n" + this.getSubscribedContent());
    }

    public void showFinishedContent() {
        System.out.println("------------------");
        System.out.println("content finished by " + this.getName() + "\n" + this.getFinishedContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getFinishedContent() {
        return finishedContent;
    }

    public void setFinishedContent(Set<Content> finishedContent) {
        this.finishedContent = finishedContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(subscribedContent, dev.subscribedContent) && Objects.equals(finishedContent, dev.finishedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedContent, finishedContent);
    }
}
