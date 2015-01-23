package butterknife.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final class ContentViewInjection {
    private final int id;
    private final Set<ContentViewBinding> viewBindings = new LinkedHashSet<ContentViewBinding>();

    ContentViewInjection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Collection<ContentViewBinding> getContentViewBindings() {
        return viewBindings;
    }

    public void addContentViewBinding(ContentViewBinding viewBinding) {
        viewBindings.add(viewBinding);
    }

    public List<Binding> getRequiredBindings() {
        List<Binding> requiredBindings = new ArrayList<Binding>();
        for (ContentViewBinding viewBinding : viewBindings) {
            if (viewBinding.isRequired()) {
                requiredBindings.add(viewBinding);
            }
        }
        return requiredBindings;
    }
}
